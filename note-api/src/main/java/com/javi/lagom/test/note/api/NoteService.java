package com.javi.lagom.test.note.api;

import akka.Done;
import akka.NotUsed;
import com.lightbend.lagom.javadsl.api.Descriptor;
import com.lightbend.lagom.javadsl.api.Service;
import com.lightbend.lagom.javadsl.api.ServiceCall;
import com.lightbend.lagom.javadsl.api.transport.Method;

public interface NoteService extends Service {

    ServiceCall<NotUsed, Note> getNote(String title);
    ServiceCall<Note, Done> createNote();
    ServiceCall<Note, Done> modifyDescription(String title);

    @Override
    default Descriptor descriptor(){
        return Service.named("notes").withCalls(
                Service.restCall(Method.GET, "/api/note/:title", this::getNote),
                Service.restCall(Method.POST, "/api/note/", this::createNote),
                Service.restCall(Method.POST, "/api/note/:title", this::modifyDescription)
        ).withAutoAcl(true);
    }
}
