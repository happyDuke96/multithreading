package org.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Demo> list = new ArrayList<>();
        list.add(new Demo());
        print(list);
    }

    public static void print(List<? extends Public> list){
        for (Public aPublic : list) {
            aPublic.getTitle();
        }
    }
    public static class Demo implements Public{
        String id;

        Integer value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public void getTitle() {
            System.out.println("DEMO");
        }
    }
    public static class Demo2 implements Public {
        String id;

        Integer value;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public void getTitle() {
            System.out.println("DEMO 2");
        }
    }

    interface Public {
        void getTitle();

    }
}