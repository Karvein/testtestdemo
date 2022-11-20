package karvein.collections;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: karvein
 * @Date: 2022/9/6
 * @Description:
 */
public class StreamTest {
    /**
     * List Stream Test
     */
    @Test
    public  void test01() {
        List<Integer> list1 = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 遍历输出符合条件的元素
        list1.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list1.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list1.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list1.stream().anyMatch(x -> x > 6);
        System.out.println("First Match：" + findFirst.get());
        System.out.println("Any match：" + findAny.get());
        System.out.println("Bigger than 6：" + anyMatch);

        List<Integer> list2 = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list2.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);
    }

    /**
     * Person Class Test
     */
    @Test
    public void tes02() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 20,"male", "New York"));
        personList.add(new Person("Jack", 7000, 20,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 20,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 20,"female", "New York"));
        personList.add(new Person("Owen", 9500, 20,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 20,"female", "New York"));

        List<String> fiterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("Salary beyond 8000 dollars: " + fiterList);
    }

    @Test
    public void test03() {
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());

        System.out.println("UpperCase:" + strList);
        System.out.println("Elements + 3:" + intListNew);
    }

    @Test
    public void test04() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("Before change:" + personList.get(0).getName() + "-->" + personList.get(0).getSalary());
        System.out.println("After change" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary());

        // 改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 10000);
            return person;
        }).collect(Collectors.toList());
        System.out.println("before second change:" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary());
        System.out.println("after second change" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary());
    }

    @Test
    public void test05() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("Before Operation:" + list);
        System.out.println("After Operation:" + listNew);
    }

    @Test
    public void test06() {
        // 输出字符串集合中每个字符串的长度
        List<String> stringList = Arrays.asList("mu", "CSDN", "hello",
                "world", "quickly");
        stringList.stream().mapToInt(String::length).forEach(System.out::println);
        // 将int集合的每个元素增加1000
        List<Integer> integerList = Arrays.asList(4, 5, 2, 1, 6, 3);
        integerList.stream().mapToInt(x -> x + 1000).forEach(System.out::println);
    }

    @Test
    public void test07() {
        List<Double> doubleList = Arrays.asList(1.0, 2.0, 3.0, 4.0, 2.0);
        double average = doubleList.stream().mapToDouble(Number::doubleValue).average().getAsDouble();
        double sum = doubleList.stream().mapToDouble(Number::doubleValue).sum();
        double max = doubleList.stream().mapToDouble(Number::doubleValue).max().getAsDouble();
        System.out.println("Average: " + average + ", Sum: " + sum + ", Max: " + max);
    }

    @Test
    public void test08() {
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        // 求和方式1
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
        // 求和方式2
        Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
        // 求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);

        // 求乘积
        Optional<Integer> product = list.stream().reduce((x, y) -> x * y);

        // 求最大值方式1
        Optional<Integer> max = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);

        System.out.println("list sum:" + sum.get() + "," + sum2.get() + "," + sum3);
        System.out.println("list product:" + product.get());
        System.out.println("list max:" + max.get() + "," + max2);
    }

    @Test
    public void test09() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 求工资之和方式1：
        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        // 求工资之和方式2：
        Integer sumSalary2 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(),
                (sum1, sum2) -> sum1 + sum2);
        // 求工资之和方式3：
        Integer sumSalary3 = personList.stream().reduce(0, (sum, p) -> sum += p.getSalary(), Integer::sum);

        // 求最高工资方式1：
        Integer maxSalary = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                Integer::max);
        // 求最高工资方式2：
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);
        // 求最高工资方式3：
        Integer maxSalary3 = personList.stream().map(Person::getSalary).reduce(Integer::max).get();

        System.out.println("Salary sum:" + sumSalary.get() + "," + sumSalary2 + "," + sumSalary3);
        System.out.println("Salary max:" + maxSalary + "," + maxSalary2 + "," + maxSalary3);
    }

    @Test
    public void test10() {
        List<Integer> list = Arrays.asList(1, 6, 3, 4, 6, 7, 9, 6, 20);
        List<Integer> listNew = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        Set<Integer> set = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toSet());

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));

        Map<?, Person> map = personList.stream().filter(p -> p.getSalary() > 8000)
                .collect(Collectors.toMap(Person::getName, p -> p));
        System.out.println("toList:" + listNew);
        System.out.println("toSet:" + set);
        System.out.println("toMap:" + map);
    }

    @Test
    public void test11() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        // 求总数
        Long count = personList.stream().collect(Collectors.counting());
        // 求平均工资
        Double average = personList.stream().collect(Collectors.averagingDouble(Person::getSalary));
        // 求最高工资
        Optional<Integer> max = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        // 求工资之和
        Integer sum = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        // 一次性统计所有信息
        DoubleSummaryStatistics collect = personList.stream().collect(Collectors.summarizingDouble(Person::getSalary));

        System.out.println("Staff Count:" + count);
        System.out.println("Average salary:" + average);
        System.out.println("Sum salary:" + sum);
        System.out.println("Collect" + collect);
    }

    @Test
    public void test12() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));


        // 将员工按薪资是否高于8000分组
        Map<Boolean, List<Person>> part = personList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 8000));
        // 将员工按性别分组
        Map<String, List<Person>> group = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        // 将员工先按性别分组，再按地区分组
        Map<String, Map<String, List<Person>>> group2 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println("Group by salary" + part);
        System.out.println("Group by sex" + group);
        System.out.println("Group by sex and region" + group2);
    }

    @Test
    public void test13() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        String names = personList.stream().map(p -> p.getName()).collect(Collectors.joining(","));
        System.out.println("Name:" + names);
        List<String> list = Arrays.asList("A", "B", "C");
        String string = list.stream().collect(Collectors.joining("-"));
        System.out.println("Concat:" + string);
    }

    @Test
    public void test14() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));

        // 每个员工减去起征点后的薪资之和（这个例子并不严谨，但一时没想到好的例子）
        Integer sum = personList.stream().collect(Collectors.reducing(0, Person::getSalary, (i, j) -> (i + j - 5000)));
        System.out.println("Sum salary after taxing:" + sum);

        // stream的reduce
        Optional<Integer> sum2 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("Sum salary:" + sum2.get());
    }

    @Test
    public void test15() {
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

        System.out.println("Order by salary asc:" + newList);
        System.out.println("Order by salary desc:" + newList2);
        System.out.println("Order by salary and age asc:" + newList3);
        System.out.println("Order by salary and age desc:" + newList4);
    }

    @Test
    public void test16() {
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Stream.of(arr1);
        Stream<String> stream2 = Stream.of(arr2);
        // concat:合并两个流 distinct：去重
        List<String> newList = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        // limit：限制从流中获得前n个数据
        List<Integer> collect = Stream.iterate(1, x -> x + 2).limit(10).collect(Collectors.toList());
        // skip：跳过前n个数据
        List<Integer> collect2 = Stream.iterate(1, x -> x + 2).skip(1).limit(5).collect(Collectors.toList());

        System.out.println("Stream merge" + newList);
        System.out.println("limit:" + collect);
        System.out.println("skip:" + collect2);
    }
}
