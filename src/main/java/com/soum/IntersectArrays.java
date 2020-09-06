package com.soum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectArrays {
  public static List<Integer> intersect(List<Integer> array1, List<Integer> array2) {
    List<Integer> result = new ArrayList<>();
    int i = 0;
    int j = 0;

    //o(m+n)
    while (i < array1.size() && j < array2.size()) {
      if (array1.get(i).equals(array2.get(j))) {
        if (i == 0 || !array1.get(i - 1).equals(array1.get(i))) {
          result.add(array1.get(i));
        }
        i++;
        j++;

      } else if (array1.get(i) > array2.get(j)) {
        j++;
      } else if (array1.get(i) < array2.get(j)) {
        i++;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    List<Integer> list1 = Arrays.asList(2, 3, 3, 5, 5, 5, 6, 7, 7, 8, 12);
    List<Integer> list2 = Arrays.asList(5, 5, 5, 6, 8, 8, 9, 10, 10);

    //o(m+n)
    System.out.println(intersect(list1, list2));
  }
}
