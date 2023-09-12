package com.s2w.preassignment.attackmanager.config;

import com.s2w.preassignment.attackmanager.adapter.repository.seed.SeedRepository;
import com.s2w.preassignment.attackmanager.domain.Seed;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Configuration
public class TestConfiguration {

    @Bean
    public SeedRepository seedRepository() {
        return new SeedRepository() {

            @Override
            public boolean existsBySeedId(String seedId) {
                return false;
            }

            @Override
            public void flush() {

            }

            @Override
            public <S extends Seed> S saveAndFlush(S entity) {
                return null;
            }

            @Override
            public <S extends Seed> List<S> saveAllAndFlush(Iterable<S> entities) {
                return null;
            }

            @Override
            public void deleteAllInBatch(Iterable<Seed> entities) {

            }

            @Override
            public void deleteAllByIdInBatch(Iterable<Long> longs) {

            }

            @Override
            public void deleteAllInBatch() {

            }

            @Override
            public Seed getOne(Long aLong) {
                return null;
            }

            @Override
            public Seed getById(Long aLong) {
                return null;
            }

            @Override
            public Seed getReferenceById(Long aLong) {
                return null;
            }

            @Override
            public <S extends Seed> List<S> findAll(Example<S> example) {
                return null;
            }

            @Override
            public <S extends Seed> List<S> findAll(Example<S> example, Sort sort) {
                return null;
            }

            @Override
            public <S extends Seed> List<S> saveAll(Iterable<S> entities) {
                return null;
            }

            @Override
            public List<Seed> findAll() {
                return null;
            }

            @Override
            public List<Seed> findAllById(Iterable<Long> longs) {
                return null;
            }

            @Override
            public <S extends Seed> S save(S entity) {
                return null;
            }

            @Override
            public Optional<Seed> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Seed entity) {

            }

            @Override
            public void deleteAllById(Iterable<? extends Long> longs) {

            }

            @Override
            public void deleteAll(Iterable<? extends Seed> entities) {

            }

            @Override
            public void deleteAll() {

            }

            @Override
            public List<Seed> findAll(Sort sort) {
                return null;
            }

            @Override
            public Page<Seed> findAll(Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Seed> Optional<S> findOne(Example<S> example) {
                return Optional.empty();
            }

            @Override
            public <S extends Seed> Page<S> findAll(Example<S> example, Pageable pageable) {
                return null;
            }

            @Override
            public <S extends Seed> long count(Example<S> example) {
                return 0;
            }

            @Override
            public <S extends Seed> boolean exists(Example<S> example) {
                return false;
            }

            @Override
            public <S extends Seed, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
                return null;
            }
        };
    }
}
