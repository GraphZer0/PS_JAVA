package PracticalWorkNumberThree;

import java.util.Arrays;

public class FamilyMember {
    private String name;

    private FamilyMember[] parents;
    private int parentCount;

    private FamilyMember[] children;
    private int childCount;

    public FamilyMember(String name) {
        this.name = name;
        this.parents = new FamilyMember[2]; // 2 родителя
        this.parentCount = 0;

        this.children = new FamilyMember[2]; // начальная вместимость 2
        this.childCount = 0;
    }


    public void addParent(String name) {
        if (parentCount == parents.length) {
            parents = Arrays.copyOf(parents, parents.length * 2);
        }
        parents[parentCount++] = new FamilyMember(name);
    }

    public void addChild(String name) {
        if (childCount == children.length) {
            children = Arrays.copyOf(children, children.length * 2);
        }
        children[childCount++] = new FamilyMember(name);
    }

    public void findRelatives() {
        System.out.println("Родители " + name + ":");
        for (int i = 0; i < parentCount; i++) {
            System.out.println("- " + parents[i].name);
        }

        System.out.println("Дети " + name + ":");
        for (int i = 0; i < childCount; i++) {
            System.out.println("- " + children[i].name);
        }
    }

    public void printTree(String indent) {
        System.out.println(indent + name);
        for (int i = 0; i < children.length && children[i] != null; i++) {
            children[i].printTree(indent + "  ");
        }
    }
}