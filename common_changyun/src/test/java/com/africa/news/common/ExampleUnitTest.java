package com.africa.news.common;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


  @Test
  public void addition_isCorrect() {
    boolean assignableFrom = a.class.isAssignableFrom(a.class);
    System.out.println(assignableFrom);
    boolean assignableFrom1 = b.class.isAssignableFrom(a.class);
    System.out.println(assignableFrom1);
    boolean assignableFrom2 = c.class.isAssignableFrom(a.class);
    System.out.println(assignableFrom2);
  }

  class a {

  }

  class b extends a {

  }

  class c extends b {
  }

}