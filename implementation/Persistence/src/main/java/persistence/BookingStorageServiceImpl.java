package persistence;

import datarecords.BookingData;

import javax.sql.DataSource;
import java.util.List;

public class BookingStorageServiceImpl implements BookingStorageService {
    private final DataSource dataSource;
    public BookingStorageServiceImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public BookingData add(BookingData bookingData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<BookingData> getAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
