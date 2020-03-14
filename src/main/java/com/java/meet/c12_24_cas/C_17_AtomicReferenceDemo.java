package com.java.meet.c12_24_cas;

import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicReference;

@Getter
@ToString
//@AllArgsConstructor
class User{
    String userName;
    int age;

    public User() {
    }

    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
}

/**
 * 17_AtomicReference原子引用
 *
 */
public class C_17_AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReference<User> atomicReference = new AtomicReference<>();

        User z3 = new User("z3", 22);
        User li4 = new User("li4", 25);
        atomicReference.set(z3);

        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t " + atomicReference.get());
        System.out.println(atomicReference.compareAndSet(z3, li4) + "\t " + atomicReference.get());

    }
}
