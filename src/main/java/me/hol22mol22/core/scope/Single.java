package me.hol22mol22.core.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Single {
    @Autowired
    private Proto proto;

    public Proto getProto() {
        return proto;
    }
}
