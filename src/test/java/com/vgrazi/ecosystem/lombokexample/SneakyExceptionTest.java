package com.vgrazi.ecosystem.lombokexample;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Slf4j
class SneakyExceptionTest{

    @Test
    public void testSneaky(){
        try{
            processCollectionWithSneaky(new SneakyExceptionTest[]{new SneakyExceptionTest(), new SneakyExceptionTest()});
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void testPublic(){
        processCollectionWithPublic(new SneakyExceptionTest[]{new SneakyExceptionTest(), new SneakyExceptionTest()});
    }

    private void processCollectionWithPublic(SneakyExceptionTest[] testers){
        Arrays.stream(testers).forEach(user -> {
            try{
                user.throwExplicitly();
            }catch(IOException e){
                e.printStackTrace();
            }
        });
    }

    private void processCollectionWithSneaky(SneakyExceptionTest[] testers) {
        Arrays.stream(testers).forEach(SneakyExceptionTest::throwSneaky);
    }

    private void callSneaky(){
        throwSneaky();
    }

    private void throwExplicitly() throws IOException{
        throw new IOException("Explicit!!");
    }
    @SneakyThrows
    private void throwSneaky() {
        throw new IOException("Sneaky!!");
    }


    @Test
    public void display() {
        log.info(toString());
        callSneaky();
    }

    @Test
    public void processCollection(List<SneakyExceptionTest> tests) {
        tests.forEach(test-> {
            try{
                test.throwExplicitly();
            }catch(IOException e){
                e.printStackTrace();
            }
        });

        tests.forEach(SneakyExceptionTest::throwSneaky);
    }
}


