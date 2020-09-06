package com.soum;

import java.util.*;

public class MergeSortedList {

  private static class Entry {
    public Integer value;
    public Integer listIndex;

    public Entry(Integer value, Integer listIndex) {
      this.value = value;
      this.listIndex = listIndex;
    }
  }

  public static List<Integer> merge(List<List<Integer>> lists) {
    List<Integer> result = new ArrayList<>();
    PriorityQueue<Entry> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));
    List<Iterator<Integer>> iterators = new ArrayList<>();

    //k - O(k)
    for (List<Integer> elements : lists) {
      iterators.add(elements.iterator());
    }

    //k - O(k)
    for (int i = 0; i < iterators.size(); i++) {
      if (iterators.get(i).hasNext()) {
        //O(log k)
        heap.add(new Entry(iterators.get(i).next(), i));
      }
    }

    //so far O(k) + O(k log k)

    // O(n-k)
    while (!heap.isEmpty()) {
      Entry entry = heap.poll();
      result.add(entry.value);
      if (iterators.get(entry.listIndex).hasNext()) {
        //O(log (k)) - there are no more than k elements in the heap. We are polling before we are adding.
        heap.add(new Entry(iterators.get(entry.listIndex).next(), entry.listIndex));
      }
    }

    //so far O(k) + O(k log k) + O(n-k log (k)) ~ O(n log (k)) considering  n >> k

    return result;
  }


  public static void main(String[] args) {
    List<List<Integer>> lists = Arrays.asList(Arrays.asList(3, 6, 10), Arrays.asList(2, 4, 6), Arrays.asList(3, 8));
    //O(n log (k))
    System.out.println(merge(lists));
  }
}
