package com.develogical;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();


  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void knowsWhatIsYourName() throws Exception {
    assertThat(queryProcessor.process("what is your Name"), containsString("Luis"));
  }

  @Test
  public void maxNumber() throws Exception {
    assertThat(queryProcessor.process("which of the following numbers is the largest: 67, 299"), containsString("299"));
  }

  @Test
  public void addNumbers() throws Exception{
    assertThat(queryProcessor.process("what is 6 plus 2"), containsString("8"));
  }

  @Test
  public void whichArePrimes() throws Exception{
    assertThat(queryProcessor.process("which of the following numbers are primes: 107, 493"), containsString("107"));
  }

  @Test
  public void operateOnThreeValues() throws Exception{
    assertThat(queryProcessor.process("what is 15 plus 0 multiplied by 5"), containsString("75"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }
}
