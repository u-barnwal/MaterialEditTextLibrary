package com.isolpro.library.materialedittext;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MaterialEditText extends RelativeLayout {

  private final Context context;

  private View mv;
  private TextInputLayout textInputLayout;
  private TextInputEditText textInputEditText;

  // - Props
  private boolean required;

  public MaterialEditText(@NonNull Context context) {
    this(context, null);
  }

  public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public MaterialEditText(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    this.context = context;

    instantiate();
    initialize();
    listen();
    defaults(
      context.getTheme().obtainStyledAttributes(attrs, R.styleable.MaterialEditText, 0, 0)
    );
  }

  private void instantiate() {
    mv = LayoutInflater.from(context).inflate(R.layout.material_edit_text, null);

    textInputLayout = mv.findViewById(R.id.til);
    textInputEditText = mv.findViewById(R.id.tiet);
  }

  private void initialize() {
    addView(mv);
  }

  private void listen() {
  }

  private void defaults(TypedArray ta) {
    setErrorContentDescription(ta.getString(R.styleable.MaterialEditText_met_errorContentDescription));
    setBoxBackgroundColor(ta.getInteger(R.styleable.MaterialEditText_met_boxBackgroundColor, Color.WHITE));
    setBoxBackgroundMode(ta.getInteger(R.styleable.MaterialEditText_met_boxBackgroundMode, 2));
    setErrorEnabled(ta.getBoolean(R.styleable.MaterialEditText_met_errorEnabled, false));
    setEnabled(ta.getBoolean(R.styleable.MaterialEditText_met_enabled, true));
    setRequired(ta.getBoolean(R.styleable.MaterialEditText_met_required, false));
    setHint(ta.getString(R.styleable.MaterialEditText_met_hint));

    setText(ta.getString(R.styleable.MaterialEditText_met_text));
    setInputType(ta.getInteger(R.styleable.MaterialEditText_met_inputType, 1));
    setMaxLines(ta.getInteger(R.styleable.MaterialEditText_met_maxLines, 1));
  }

  public CharSequence getErrorContentDescription() {
    return textInputLayout.getErrorContentDescription();
  }

  public void setErrorContentDescription(String errorContentDescription) {
    textInputLayout.setErrorContentDescription(errorContentDescription);
  }

  public Integer getBoxBackgroundColor() {
    return textInputLayout.getBoxBackgroundColor();
  }

  public void setBoxBackgroundColor(@ColorInt int boxBackgroundColor) {
    textInputLayout.setBoxBackgroundColor(boxBackgroundColor);
  }

  public Integer getBoxBackgroundMode() {
    return textInputLayout.getBoxBackgroundMode();
  }

  public void setBoxBackgroundMode(int boxBackgroundMode) {
    textInputLayout.setBoxBackgroundMode(boxBackgroundMode);
  }

  public boolean getErrorEnabled() {
    return textInputLayout.isErrorEnabled();
  }

  public void setErrorEnabled(boolean errorEnabled) {
    textInputLayout.setErrorEnabled(errorEnabled);
  }

  public boolean getEnabled() {
    return textInputLayout.isEnabled();
  }

  public void setEnabled(boolean enabled) {
    textInputLayout.setEnabled(enabled);
  }

  public boolean isRequired() {
    return required;
  }

  public void setRequired(boolean required) {
    this.required = required;
  }

  public CharSequence getHint() {
    return textInputLayout.getHint();
  }

  public void setHint(String hint) {
    textInputLayout.setHint(hint);
  }

  public CharSequence getText() {
    return textInputEditText.getText();
  }

  public void setText(String text) {
    textInputEditText.setText(text);
  }

  public int getInputType() {
    return textInputEditText.getInputType();
  }

  public void setInputType(int inputType) {
    textInputEditText.setInputType(inputType);
  }

  public int getMaxLines() {
    return textInputEditText.getMaxLines();
  }

  public void setMaxLines(int maxLines) {
    textInputEditText.setMaxLines(maxLines);
  }


}
