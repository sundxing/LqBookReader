package com.lqtemple.android.lqbookreader.model;

/**
 * Created by sundxing on 16/12/25.
 * 段落，包含文本索引
 */

public class Content {
    JContent mJContent;
    private int mOffset;
    private int mParagraphIndex;
    private int totalOffset;

    public Content(JContent JContent) {
        mJContent = JContent;
        mParagraphIndex = extractParagraphIndex(mJContent.getIndex());
    }

    private int extractParagraphIndex(String index) {
        return Integer.valueOf(index.substring(0, index.indexOf("-")));
    }

    public int getOffset() {
        return mOffset;
    }

    public void setOffset(int offset) {
        mOffset = offset;
    }

    public int getParagraphIndex() {
        return mParagraphIndex;
    }

    @Override
    public String toString() {
        return "Index" + mJContent.getIndex() + ", offset:" + mOffset;
    }

    public Type getTypeEnum() {
        return mJContent.getTypeEnum();
    }

    public String getIndex() {
        return mJContent.getIndex();
    }

    public CharSequence getText() {
        return mJContent.getText();
    }

    public boolean isChapterStart() {
        if (mJContent.getType() != Type.Title.ordinal()) return false;
        String[] indexStr = getIndex().split("-");
        return indexStr.length == 2 && indexStr[1].equals("0");
    }

    public int getTotalOffset() {
        return totalOffset;
    }

    public void setTotalOffset(int totalOffset) {
        this.totalOffset = totalOffset;
    }
}
