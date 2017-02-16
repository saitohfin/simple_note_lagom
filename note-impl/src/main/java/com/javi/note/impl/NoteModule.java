package com.javi.note.impl;

import com.google.inject.AbstractModule;
import com.javi.lagom.test.note.api.NoteService;
import com.lightbend.lagom.javadsl.server.ServiceGuiceSupport;

public class NoteModule extends AbstractModule implements ServiceGuiceSupport {

    @Override
    protected void configure() {
        bindServices(
                serviceBinding(NoteService.class, NoteServiceImpl.class)
        );
    }
}
