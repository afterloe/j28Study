# Collectors类的静态工厂方法

> author: afterloe  
> mail: lm6289511@gmail.com  
> version: 0.0.1  

## toList
> 把流中所有项目收集到一个 List

```java
List<Dish> dishes = menuStream.collect(toList());
```

## toSet
> 把流中所有项目收集到一个 Set, 删除重复项

```java
Set<Dish> dishes = menuStream.collect(toSet());
```

## toCollection
> 把流中所有项目收集到给定的供应源创建的集合

```java
Collection<Dish> dishes = menuStream.collect(toCollection(),ArrayList::new);
```

## counting
> 计算流中元素的个数, 返回 Long类型

```java
long howManyDishes = menuStream.collect(counting());
```

## summingInt
> 对流中项目的一个整数属性求和

```java
int totalCalories = menuStream.collect(summingInt(Dish::getCalories));
```

## averagingInt
> 计算流中项目 Integer 属性的平均值

```java
double avgCalories = menuStream.collect(averagingInt(Dish::getCalories));
```

## summarizingInt
> 收集关于流中项目 Integer 属性的统计值，例如最大、最小、总和与平均值

```java
IntSummaryStatistics menuStatistics = menuStream.collect(summarizingInt(Dish::getCalories));
```

## joining
> 调用toString 方法 生成流中的元素的字符串

```java
String shortMenu = menuStream.map(Dish::getName).collect(joining(", "));
```

## maxBy
> 比较器选出的最大元素的 Optional，或如果流为空则为 Optional.empty()

```java
Optional<Dish> fattest = menuStream.collect(maxBy(comparingInt(Dish::getCalories)));
```

## minBy
> 比较器选出的最小元素的 Optional，或如果流为空则为 Optional.empty()

```java
Optional<Dish> fattest = menuStream.collect(minBy(comparingInt(Dish::getCalories)));
```

## reducing
> 从一个作为累加器的初始值开始，利用 BinaryOperator 与流 中的元素逐个结合，从而将流归约为单个值

```java
int totalCalories = menuStream.collect(reducing(0, Dish::getCalories, Integer::sum));
```

## collectingAndThen
> 包裹另一个收集器，对其结果应用转换函数

```java
int howManyDishes = menuStream.collect(collectingAndThen(toList(), List::size));
```

## partitioningBy
> 根据对流中每个项目应用谓词的结果来对项目进行分区(boolean)

```java
Map<Boolean,List<Dish>> vegetarianDishes = menuStream.collect(partitioningBy(Dish::isVegetarian));
```