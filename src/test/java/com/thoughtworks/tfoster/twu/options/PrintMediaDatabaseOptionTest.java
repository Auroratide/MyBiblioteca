package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.MediaDatabase;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintMediaDatabaseOptionTest {

    @Test
    public void shouldPrintLibraryWhenRun() throws Exception {
        MediaDatabase mediaDatabase = mock(MediaDatabase.class);
        PrintMediaDatabaseOption option = new PrintMediaDatabaseOption(mediaDatabase);
        option.run();

        verify(mediaDatabase).print();
    }

}