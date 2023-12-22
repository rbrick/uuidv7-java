uuidv7-java
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