package com.patpaw.service;


import com.mongodb.MongoClient;
import de.flapdoodle.embed.mongo.MongodExecutable;

import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.junit.*;
import org.springframework.data.mongodb.core.MongoTemplate;


import static org.junit.Assert.*;

public class AnimalServiceImplTest {

    private static final String LOCALHOST = "localhost";
    private static final String DB_NAME = "AnimalDb";
    private static final int PORT = 27017;

    private AnimalServiceImpl serviceImpl;
    private MongodExecutable mongodExecutable;
    private MongoTemplate template;


    @Before
    public void setUp() throws Exception {
        serviceImpl = new AnimalServiceImpl();

        IMongodConfig mongodConfig = new MongodConfigBuilder().version(Version.Main.PRODUCTION)
                .net(new Net(LOCALHOST, PORT, Network.localhostIsIPv6()))
                .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        template = new MongoTemplate(new MongoClient(LOCALHOST, PORT),DB_NAME);
    }

    @After
    public void tearDown() throws Exception {
        mongodExecutable.stop();
    }

    @Test
    public void saveOrUpdate() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void insert() {
    }
}