package hw12_Comparator;
/*
Soldiers have always been, are and will always be lined up in descending order of height. Sort the soldiers,
thinking beforehand what is better to use under these conditions - Comparable or Comparator.
Implement the Soldier class. You can do it with a single field - height. Create a collection of soldiers and sort it.
It's up to you whether you use Comparable or Comparator, but you need to explain your choice.
 */
//Comparable - делает наши объекты «сравнимыми» и создает для них наиболее естественный порядок сортировки.

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Soldier soldier1 = new Soldier("Moreno", 189);
        Soldier soldier2 = new Soldier("Hardy", 202);
        Soldier soldier3 = new Soldier("Rocky", 172);
        Soldier soldier4 = new Soldier("Duglas", 169);
        Soldier soldier5 = new Soldier("Sommer", 174);

        List<Soldier> soldiers = new ArrayList<>(Arrays.asList(soldier1, soldier2, soldier3, soldier4, soldier5));
        Collections.sort(soldiers);
        System.out.println(soldiers);
    }
}
