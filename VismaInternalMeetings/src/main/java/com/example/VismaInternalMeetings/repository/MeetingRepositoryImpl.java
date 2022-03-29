package com.example.VismaInternalMeetings.repository;


import com.example.VismaInternalMeetings.model.Meeting;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class MeetingRepositoryImpl implements MeetingRepository {


    @Override
    public List<Meeting> findAll() {
        return null;
    }

    @Override
    public List<Meeting> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Meeting> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Meeting> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Meeting entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Meeting> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Meeting> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Meeting> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Meeting> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Meeting> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Meeting> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Meeting> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<String> strings) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Meeting getOne(String s) {
        return null;
    }

    @Override
    public Meeting getById(String s) {
        return null;
    }

    @Override
    public <S extends Meeting> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Meeting> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Meeting> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Meeting> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Meeting> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Meeting> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Meeting, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public List<Meeting> findByResponsiblePerson(String responsiblePerson) {
        return null;
    }

    @Override
    public List<Meeting> findByCategory(String category) {
        return null;
    }

    @Override
    public List<Meeting> findByType(String type) {
        return null;
    }

    @Override
    public List<Meeting> findByStartDateAfter(LocalDateTime startDate) {
        return null;
    }

    @Override
    public List<Meeting> findByEndsDateBefore(LocalDateTime endDate) {
        return null;
    }

    @Override
    public List<Meeting> findByAttendees() {
        return null;
    }

    @Override
    public List<Meeting> findByDescription(String description) {
        return null;
    }



    @Override
    public Optional<Meeting> findById(Long id) {
        return Optional.empty();
    }
}
