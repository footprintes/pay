package com.pay.comm.editor;

import org.springframework.util.StringUtils;

import java.beans.PropertyEditorSupport;

;


public class MyStringTrimmerEditor extends PropertyEditorSupport {


    private final String charsToDelete;

    private final boolean emptyAsNull;


    /**
     * Create a new StringTrimmerEditor.
     *
     * @param emptyAsNull <code>true</code> if an empty String is to be
     *                    transformed into <code>null</code>
     */
    public MyStringTrimmerEditor(boolean emptyAsNull) {
        this.charsToDelete = null;
        this.emptyAsNull = emptyAsNull;
    }

    /**
     * Create a new StringTrimmerEditor.
     *
     * @param charsToDelete a set of characters to delete, in addition to
     *                      trimming an input String. Useful for deleting unwanted line breaks:
     *                      e.g. "\r\n\f" will delete all new lines and line feeds in a String.
     * @param emptyAsNull   <code>true</code> if an empty String is to be
     *                      transformed into <code>null</code>
     */
    public MyStringTrimmerEditor(String charsToDelete, boolean emptyAsNull) {
        this.charsToDelete = charsToDelete;
        this.emptyAsNull = emptyAsNull;
    }


    @Override
    public void setAsText(String text) {
        if (text == null) {
            setValue(null);
        } else {
            String value = text.trim();
            if (this.charsToDelete != null) {
                value = StringUtils.deleteAny(value, this.charsToDelete);
            }
            if (this.emptyAsNull && "".equals(value)) {
                setValue(null);
            } else {

                // 加入字符过滤替换
                value = replaceHtmlCh(value);

                setValue(value);
            }
        }
    }

    /**
     * 替换html标签特殊字符
     *
     * @param str
     * @return str
     */
    private String replaceHtmlCh(String str) {
        str = str.replace("&", "&amp;");
        str = str.replace("<", "&lt;");
        str = str.replace(">", "&gt;");
        return str;
    }

    @Override
    public String getAsText() {
        Object value = getValue();
        return (value != null ? value.toString() : "");
    }

}
