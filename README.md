uuidv7-java [![Java CI with Maven](https://github.com/rbrick/uuidv7-java/actions/workflows/maven.yml/badge.svg)](https://github.com/rbrick/uuidv7-java/actions/workflows/maven.yml)
---

Example Usage:

```java

import io.rcw.uuidv7.UUIDv7;

import java.security.SecureRandom;

class Example {
    public static void main(String[] args) {
        System.out.println(UUIDv7.newUUIDv7(new SecureRandom()));
    }
}


```
