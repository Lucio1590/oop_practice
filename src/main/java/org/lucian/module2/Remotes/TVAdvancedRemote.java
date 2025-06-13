package org.lucian.module2.Remotes;

public class TVAdvancedRemote extends TVBasicRemote {
    private final TV tv;
    public TVAdvancedRemote(TV tv) {
        super(tv);
        this.tv = tv;
    }
    public void setVolume(int level) {
        tv.setVolume(level);
    }
}
