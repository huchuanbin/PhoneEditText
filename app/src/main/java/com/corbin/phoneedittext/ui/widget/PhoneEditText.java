package com.corbin.phoneedittext.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Author:      Corbin
 * Version:     v1.0
 * Date:        16/7/20
 * Description:
 * Modification  History
 * Date             Author             Version             Description
 * ---------------------------------------------------------------------------
 * 16/7/20          Corbin             v1.0
 * Why & What is modified:
 */
public class PhoneEditText extends EditText {
    private PhoneNumInterface phoneNumFinish;

    public PhoneEditText(Context context) {
        super(context);
    }

    public PhoneEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PhoneEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setPhoneNumFinish(PhoneNumInterface phoneNumFinish) {
        this.phoneNumFinish = phoneNumFinish;
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (text.length() == 13) {
            if (phoneNumFinish != null) {
                String phone = text.toString().replaceAll("\\s", "");
                phoneNumFinish.phoneNumFinish(phone);
            }
        }
        if (text == null || text.length() == 0) return;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (i != 3 && i != 8 && text.charAt(i) == ' ') {
                continue;
            } else {
                sb.append(text.charAt(i));
                if ((sb.length() == 4 || sb.length() == 9) && sb.charAt(sb.length() - 1) != ' ') {
                    sb.insert(sb.length() - 1, ' ');
                }
            }
        }
        if (!sb.toString().equals(text.toString())) {
            int index = start + 1;
            if (sb.charAt(start) == ' ') {
                if (lengthBefore == 0) {
                    index++;
                } else {
                    index--;
                }
            } else {
                if (lengthBefore == 1) {
                    index--;
                }
            }
            setText(sb.toString());
            setSelection(index);
        }
    }

    public interface PhoneNumInterface {
        void phoneNumFinish(String phone);
    }
}
