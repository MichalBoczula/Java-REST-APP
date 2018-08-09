package com.crud.tasks.controller;

public class DeleteTaskException extends Exception {
    @Override
    public String getMessage() {
        return "Task with this Id not exists";
    }
}
