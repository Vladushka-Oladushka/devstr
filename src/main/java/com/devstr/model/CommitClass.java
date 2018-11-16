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

        if (numberOfLinesAdded != that.numberOfLinesAdded) return false;
        if (numberOfLinesChanged != that.numberOfLinesChanged) return false;
        if (numberOfLinesDeleted != that.numberOfLinesDeleted) return false;
        return className.equals(that.className);
    }

    @Override
    public int hashCode() {
        int result = className.hashCode();
        result = 31 * result + numberOfLinesAdded;
        result = 31 * result + numberOfLinesChanged;
        result = 31 * result + numberOfLinesDeleted;
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
