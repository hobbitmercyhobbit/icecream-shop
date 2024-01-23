package com.mycompany.icecreamshop;

class GiveFeedbackCommand implements Command {

    private final String feedback;

    public GiveFeedbackCommand(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        System.out.println("Feedback: " + feedback);
    }
}