package com.intuit.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MusicalInstrumentUnitTest {
    MusicalPlay musicalPlay;
    MusicalInstrument musicalInstrument;
    @BeforeEach
    void init() {
        musicalPlay = Mockito.mock(MusicalPlay.class);
        musicalInstrument = new MusicalInstrument(musicalPlay);
    }

    @Test
    void givenInvalidString_WhenGetMinDeletion_PrintsError() {
        //Given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Mockito.when(musicalPlay.getMinDeletionToMakeGoodPlay(ArgumentMatchers.anyString())).thenReturn(-1);

        //When
        musicalInstrument.getMinRemovals("ok");

        //Then
        Assertions.assertEquals(Constants.INVALID_INPUT, outputStreamCaptor.toString().trim());
    }


    @Test
    void givenValidString_WhenGetMinDeletion_PrintsResult() {
        //Given
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Mockito.when(musicalPlay.getMinDeletionToMakeGoodPlay(ArgumentMatchers.anyString())).thenReturn(5);

        //When
        musicalInstrument.getMinRemovals("abc");

        //Then
        Assertions.assertEquals(Constants.OUTPUT_RESULT_PREFIX + "5", outputStreamCaptor.toString().trim());
    }
}
