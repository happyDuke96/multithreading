package org.multithreading;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Demo demo = new Demo();
        demo.setId("zzz");
//        System.out.println(demo.getClass().getField("value").getByte("value"));


//        System.out.println(new String("Маршрутная квитанция".getBytes(), StandardCharsets.UTF_8));
        System.out.println("Маршрутная квитанция" + '\ufeff');

        Charset charset = Charset.forName("UTF-8");
    }

    public static class Demo{
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
    }
}