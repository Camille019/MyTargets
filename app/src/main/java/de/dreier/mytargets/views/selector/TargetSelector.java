/*
 * MyTargets Archery
 *
 * Copyright (C) 2015 Florian Dreier
 * All rights reserved
 */

package de.dreier.mytargets.views.selector;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.dreier.mytargets.R;
import de.dreier.mytargets.activities.ItemSelectActivity;
import de.dreier.mytargets.shared.models.Target;

public class TargetSelector extends SelectorBase<Target> {

    public TargetSelector(Context context) {
        this(context, null);
    }

    public TargetSelector(Context context, AttributeSet attrs) {
        super(context, attrs, R.layout.item_image);
        setOnClickActivity(ItemSelectActivity.TargetActivity.class);
    }

    @Override
    protected void bindView() {
        ImageView img = (ImageView) mView.findViewById(R.id.image);
        TextView name = (TextView) mView.findViewById(R.id.name);
        TextView details = (TextView) mView.findViewById(R.id.details);
        details.setVisibility(View.VISIBLE);
        img.setImageDrawable(item.getDrawable());
        name.setText(String.format("%s (%s)", item.getModel().getName(getContext()), item.size.toString(getContext())));
        details.setText(item.getModel().getScoringStyles().get(item.scoringStyle));
    }
}
