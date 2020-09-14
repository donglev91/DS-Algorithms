package datastructure;

import org.junit.Test;

public class StringBuilderTest {
    @Test
    public void add2Strings_ShouldOk () {
        StringBuilder builder1 = new StringBuilder("aaa");
        StringBuilder builder2 = new StringBuilder("bbb");
        StringBuilder builder = builder1.append(builder1);
        System.out.println(builder.toString());
    }
}
