package ua.com.juja.controller.web;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.com.juja.controller.web.actions.ErrorAction;
import ua.com.juja.service.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class ActionResolver {

    private List<Action> actions;

    @Autowired
    private Service service;

    @Autowired
    public ActionResolver(Service service) {
        this.service = service;
        actions = new LinkedList<>();
        Reflections reflections = new Reflections(ErrorAction.class.getPackage().getName());
        Set<Class<? extends AbstractAction>> classes = reflections.getSubTypesOf(AbstractAction.class);
        for (Class<? extends AbstractAction> aClass : classes) {
            if (aClass.equals(ErrorAction.class)) {
                continue;
            }
            try {
                AbstractAction action = aClass.getConstructor(Service.class).newInstance(service);
                actions.add(action);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        actions.add(new ErrorAction(service));
    }

    public Action getAction(String url) {
        for (Action action : actions) {
            if (action.canProcess(url)) {
                return action;
            }
        }
        return new NullAction(service);
    }
}
