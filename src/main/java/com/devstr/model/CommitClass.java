package com.devstr.model;

public class CommitClass {

    private String className;
    private int numberOfLinesAdded;
    private int numberOfLinesChanged;
    private int numberOfLinesDeleted;

    private CommitClass() {
    }

    public String getClassName() {
        return className;
    }

    public int getNumberOfLinesAdded() {
        return numberOfLinesAdded;
    }

    public int getNumberOfLinesChanged() {
        return numberOfLinesChanged;
    }

    public int getNumberOfLinesDeleted() {
        return numberOfLinesDeleted;
    }

    public static CommitClassBuilder builder() {
        return new CommitClass().new CommitClassBuilder();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommitClass that = (CommitClass) o;

        if (getNumberOfLinesAdded() != that.getNumberOfLinesAdded()) return false;
        if (getNumberOfLinesChanged() != that.getNumberOfLinesChanged()) return false;
        if (getNumberOfLinesDeleted() != that.getNumberOfLinesDeleted()) return false;
        return getClassName() != null ? getClassName().equals(that.getClassName()) : that.getClassName() == null;
    }

    @Override
    public int hashCode() {
        int result = getClassName() != null ? getClassName().hashCode() : 0;
        result = 31 * result + getNumberOfLinesAdded();
        result = 31 * result + getNumberOfLinesChanged();
        result = 31 * result + getNumberOfLinesDeleted();
        return result;
    }

    public class CommitClassBuilder {

        private CommitClassBuilder(){
        }

        public CommitClassBuilder setClassName(String name) {
            CommitClass.this.className = name;
            return this;
        }

        public CommitClassBuilder setAddedLines(int number) {
            CommitClass.this.numberOfLinesAdded = number;
            return this;
        }

        public CommitClassBuilder setChangedLines(int number) {
            CommitClass.this.numberOfLinesChanged = number;
            return this;
        }

        public CommitClassBuilder setDeletedLines(int number) {
            CommitClass.this.numberOfLinesDeleted = number;
            return this;
        }

        public CommitClass build() {
            return CommitClass.this;
        }

    }

}
