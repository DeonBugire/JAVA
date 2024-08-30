package ru.gb.oseminar.service;

import ru.gb.oseminar.data.Stream;
import ru.gb.oseminar.data.StreamComparator;
import java.util.Collections;
import java.util.List;

public class StreamService {

    public List<Stream> getSortedStreams(List<Stream> streams) {
        streams.sort(new StreamComparator());
        return streams;
    }
}
