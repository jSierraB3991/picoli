package com.jsierrab3991.picocli.springboot.runner;

import com.jsierrab3991.picocli.springboot.command.LoadCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;
import picocli.CommandLine.IFactory;

@Component
@RequiredArgsConstructor
public class Runner implements CommandLineRunner, ExitCodeGenerator {

    private final IFactory factory;
    private final LoadCommand loadCommand;
    private int exitCode;

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(loadCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
