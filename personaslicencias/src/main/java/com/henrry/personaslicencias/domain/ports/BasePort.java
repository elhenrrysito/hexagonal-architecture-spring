package com.henrry.personaslicencias.domain.ports;

import java.util.List;

public interface BasePort<T> {
    T add(T t);
    void deleteById(Long id);
    T update(T t);
    List<T> getAll();
    T getById(Long id);

}
