package com.javi.lagom.test.note.api;

import akka.Done;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

public interface NoteService extends Service {

    ServiceCall<Note, Done> createNote();

    @Override
    default Descriptor descriptor(){
        return Service.named("notes").withCalls(
                Service.restCall(Method.POST, "/api/note/", this::createNote)
        ).withAutoAcl(true);
    }
}
