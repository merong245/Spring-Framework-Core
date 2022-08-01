package me.hol22mol22.core;

import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS) // 기본값
@Documented
@Target(ElementType.METHOD)
public @interface PerfLogging {
}
