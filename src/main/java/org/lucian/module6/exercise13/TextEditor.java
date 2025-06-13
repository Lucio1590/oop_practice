package org.lucian.module6.exercise13;

import java.util.Stack;

/**
 * EditorState acts as the Memento, storing the content of the editor.
 */
class EditorState {
    private final String content;
    public EditorState(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
}

/**
 * History acts as the Caretaker, storing previous states using a stack.
 */
class History {
    private final Stack<EditorState> states = new Stack<>();
    public void push(EditorState state) {
        states.push(state);
    }
    public EditorState pop() {
        if (!states.isEmpty()) {
            return states.pop();
        }
        return null;
    }
    public boolean isEmpty() {
        return states.isEmpty();
    }
}

/**
 * TextEditor acts as the Originator, modifying content and saving/restoring state.
 */
public class TextEditor {
    private String content = "";
    private final History history = new History();

    public void setText(String text) {
        // Save current state before changing
        history.push(new EditorState(content));
        content = text;
    }

    public void appendText(String text) {
        history.push(new EditorState(content));
        content += text;
    }

    public void undo() {
        EditorState prev = history.pop();
        if (prev != null) {
            content = prev.getContent();
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public String getText() {
        return content;
    }
}
