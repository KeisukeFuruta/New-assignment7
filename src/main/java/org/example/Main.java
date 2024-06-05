package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    //7回講義で紹介されたものは一通り実装。
    List<Integer> numberList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    numberList.stream()
        .filter(number -> number <= 5)
        .forEach(System.out::println);
    System.out.println();

    System.out.println("リスト内の偶数は" + numberList.stream()
        .filter(number -> number % 2 == 0)
        .count() + "個");
    System.out.println();

    List<String> studentList = List.of("Keisuke", "Michiko", "Tatsuya", "Marina", "Keisuke");

    studentList.stream()
        .map(String::toUpperCase)
        .sorted()
        .distinct()
        .limit(3)
        .forEach(System.out::println);
    System.out.println();

    System.out.println(studentList.stream()
        .map(String::toUpperCase)
        .sorted()
        .distinct()
        .limit(3)
        .collect(Collectors.joining(",")));
    System.out.println();

    System.out.println(studentList.stream()
        .sorted()
        .findFirst());
    System.out.println();

    // 文字列のリストを作る、要素数は10個
    // 文字列が2つ以上のものを抽出して、文字列に変換。区切り文字はカンマ(,)で行う
    // その文字列を出力してください。
    List<String> employeeList = List.of("萌苗", "知佳", "優希", "大久保", "華", "慧介", "翔太郎",
        "美知子", "葵", "愛");
    System.out.println("従業員リストの要素数は「" + employeeList.size() + "」");
    System.out.println("文字列が2つ以上のリストは、" + employeeList.stream()
        .filter(v -> v.length() >= 2)
        .collect(Collectors.joining(",")));
    System.out.println();

    // 数値のリストを作ってください。要素数は10個
    // その数値の中の奇数のものだけを抽出して、平均値を出してください
    // その平均値を出力してください。
    List<Integer> scoreList = List.of(89, 50, 68, 90, 88, 95, 79, 100, 53, 97);
    System.out.println("英語テストの点数リストの要素数は「" + scoreList.size() + "」");
    System.out.println("点数が奇数だけの平均値は「" + scoreList.stream()
        .filter(v -> v % 2 == 1)
        .collect(Collectors.averagingInt(Integer::intValue)) + "」点");

    // 生成AIを使って、StreamAPIの基礎的な課題を一つ作ってもらってください。
    // それを実際に実装してみてください。
    // 問題文説明: 与えられたテキストから単語を抽出し、以下の操作を行います
    // すべての単語を小文字に変換します。
    // 重複する単語を削除します。→してる？
    // 各単語の出現回数をカウントします。
    // 出現回数が多い順にソートします。
    // 結果をコンソールに出力します。
    String text = "Java is a high-level programming language. Java is widely used for building enterprise-scale applications.";

    // 変数text内にある単語を抽出。ただし「-」や「.」、半角スペースは除去するべく、.splitメソッドを使って、"\\W+"の正規表現で抽出。
    List<String> words = Arrays.asList(text.toLowerCase().split("\\W+"));
    Map<String, Long> wordsCount = words.stream()
        .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    System.out.println(wordsCount);

    wordsCount.entrySet().stream() /*Map型のwordsCountをentrySetメソッドを使うことによってStreamAPIを使えるようにした*/
        .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
        .forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
    System.out.println();

    // もう一問追加
    // 課題3: 文字列リストの処理
    // 説明: 文字列のリストがあります。このリストから特定の条件を満たす文字列を抽出し、文字数順にソートして出力します。
    // 手順:
    // 文字列のリストを作成します。
    // 文字数が4以上の文字列を抽出します。
    // そのリストを文字数の昇順にソートします。
    // 結果をコンソールに出力します
    List<String> strings = Arrays.asList("apple", "banana", "pear", "kiwi", "grape");
    System.out.println(strings.stream()
        .filter(v -> v.length() > 2)
        .sorted(Comparator.comparingInt(String::length))
        .toList());
    //comparatorで文字列の長さを比較
  }
}
