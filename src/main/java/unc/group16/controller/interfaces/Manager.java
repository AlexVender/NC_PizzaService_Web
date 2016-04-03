package unc.group16.controller.interfaces;

import unc.group16.data.interfaces.TableRecord;

import javax.ejb.Local;

@Local
public interface Manager <T extends TableRecord> {
    Long create(T t);
    T read(Long id);
    T[] readAll();
    boolean update(T t);
    boolean delete(Long id);
}
