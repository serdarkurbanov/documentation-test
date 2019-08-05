package com.test;

import com.github.flussig.check.*;

import java.io.File;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CheckMetadata(id = "countCheck")
public class CountCheck extends SingleExecutionCheck {
    public CountCheck(String argument, File file) {
        super(argument, file);
    }

    @Override
    public CheckResult performCheck() {
        List<String> allStrings = Arrays.asList(argument.split("\n")).stream()
                .map(s -> s.trim())
                .filter(s -> !((String) s).isEmpty())
                .collect(Collectors.toList());

        if(allStrings.size() == 4) {
            return new CheckResult("", LocalDateTime.now(), CheckStatus.GREEN);
        } else {
            return new CheckResult("", LocalDateTime.now(), CheckStatus.RED);
        }
    }
}
