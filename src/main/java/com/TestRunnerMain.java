package com;

import com.beust.jcommander.internal.Lists;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.testng.TestNG;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static java.lang.System.exit;

public class TestRunnerMain {

    public static void main(String [] args) throws IOException {
        ReportPortalTestNGListener listener = new ReportPortalTestNGListener();
        TestNG testNg = new TestNG();
        List<String> lSuites = Lists.newArrayList();
        ImmutableSet<ClassPath.ClassInfo> classes= ClassPath.from(TestRunnerMain.class.getClassLoader())
                .getTopLevelClasses("com.tests");
        System.out.println(classes.toString());
        Class [] c= classes.stream().map(ClassPath.ClassInfo::load).toArray(Class[]::new);

    }
}
