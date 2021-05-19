package leetcode;

import javafx.util.Pair;
import leetcode.baseStructure.Array;
import org.junit.Test;

import java.util.*;

//There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
//        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//        Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//        Example 1:
//        Input: numCourses = 2, prerequisites = [[1,0]]
//        Output: true
//        Explanation: There are a total of 2 courses to take.
//                     To take course 1 you should have finished course 0. So it is possible.
//        Example 2:
//        Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
//        Output: false
//        Explanation: There are a total of 2 courses to take.
//                     To take course 1 you should have finished course 0, and to take course 0 you should
//                     also have finished course 1. So it is impossible.
//        Constraints:
//        The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
//        You may assume that there are no duplicate edges in the input prerequisites.
//        1 <= numCourses <= 10^5
public class Test0207_CourseSchedule {
    private static Map<Integer, List<Integer>> dict;
    private static Set<Integer> cache;
    private static Set<Integer> whiteList;
    private boolean canFinish(int numCourses, int[][] prerequisites) {
        dict = new HashMap<>();
        cache = new HashSet<>();
        whiteList = new HashSet<>();
        for (int[] classes : prerequisites) {
            List<Integer> before = dict.getOrDefault(classes[0], new ArrayList<>());
            before.add(classes[1]);
            dict.put(classes[0], before);
        }
        for (int i = 0; i < numCourses && i < prerequisites.length; i++) {
            Set<Integer> memory = new HashSet<>();
            if (!checkCycle(prerequisites[i][0], memory)) {
                return false;
            }
            whiteList.addAll(cache);
        }
        return true;
    }

    private boolean checkCycle(int num, Set<Integer> memory) {
        if (whiteList.contains(num)) {
            return true;
        }
        if (memory.contains(num)) {
            return false;
        }
        memory.add(num);
        cache.add(num);
        if (dict.containsKey(num)) {
            for (int i : dict.get(num)) {
                if (!checkCycle(i, memory)) {
                    return false;
                }
            }
        }
        memory.remove(num);
        return true;
    }

    @Test
    public void test() {
        Map<Pair<Integer, int[][]>, Boolean> testMap = new HashMap<>();
        testMap.put(new Pair<>(3, Array.convert("[[1, 4], [2, 4], [3, 1], [3, 2]]")), true);
        testMap.put(new Pair<>(2, Array.convert("[[1, 0], [0, 1]]")), false);
        testMap.put(new Pair<>(3, Array.convert("[[0,1],[0,2],[1,2]]")), true);
        testMap.put(new Pair<>(100, Array.convert("[[1,0],[2,0],[2,1],[3,1],[3,2],[4,2],[4,3],[5,3],[5,4],[6,4],[6,5],[7,5],[7,6],[8,6],[8,7],[9,7],[9,8],[10,8],[10,9],[11,9],[11,10],[12,10],[12,11],[13,11],[13,12],[14,12],[14,13],[15,13],[15,14],[16,14],[16,15],[17,15],[17,16],[18,16],[18,17],[19,17],[19,18],[20,18],[20,19],[21,19],[21,20],[22,20],[22,21],[23,21],[23,22],[24,22],[24,23],[25,23],[25,24],[26,24],[26,25],[27,25],[27,26],[28,26],[28,27],[29,27],[29,28],[30,28],[30,29],[31,29],[31,30],[32,30],[32,31],[33,31],[33,32],[34,32],[34,33],[35,33],[35,34],[36,34],[36,35],[37,35],[37,36],[38,36],[38,37],[39,37],[39,38],[40,38],[40,39],[41,39],[41,40],[42,40],[42,41],[43,41],[43,42],[44,42],[44,43],[45,43],[45,44],[46,44],[46,45],[47,45],[47,46],[48,46],[48,47],[49,47],[49,48],[50,48],[50,49],[51,49],[51,50],[52,50],[52,51],[53,51],[53,52],[54,52],[54,53],[55,53],[55,54],[56,54],[56,55],[57,55],[57,56],[58,56],[58,57],[59,57],[59,58],[60,58],[60,59],[61,59],[61,60],[62,60],[62,61],[63,61],[63,62],[64,62],[64,63],[65,63],[65,64],[66,64],[66,65],[67,65],[67,66],[68,66],[68,67],[69,67],[69,68],[70,68],[70,69],[71,69],[71,70],[72,70],[72,71],[73,71],[73,72],[74,72],[74,73],[75,73],[75,74],[76,74],[76,75],[77,75],[77,76],[78,76],[78,77],[79,77],[79,78],[80,78],[80,79],[81,79],[81,80],[82,80],[82,81],[83,81],[83,82],[84,82],[84,83],[85,83],[85,84],[86,84],[86,85],[87,85],[87,86],[88,86],[88,87],[89,87],[89,88],[90,88],[90,89],[91,89],[91,90],[92,90],[92,91],[93,91],[93,92],[94,92],[94,93],[95,93],[95,94],[96,94],[96,95],[97,95],[97,96],[98,96],[98,97],[99,97]]")), true);
        testMap.entrySet().stream()
                .filter(entry -> canFinish(entry.getKey().getKey(), entry.getKey().getValue()) != entry.getValue())
                .findAny()
                .ifPresent(entry -> System.out.println(entry.getKey()));
    }
}
