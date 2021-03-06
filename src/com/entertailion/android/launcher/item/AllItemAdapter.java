/*
 * Copyright (C) 2012 ENTERTAILION LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.entertailion.android.launcher.item;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.entertailion.android.launcher.R;

/**
 * Adapter for displaying all apps in a dialog.
 * 
 * @author leon_nicholls
 * 
 */
public class AllItemAdapter extends ArrayAdapter<ItemInfo> {
	private LayoutInflater inflater;

	/**
	 * Data structure to cache references for performance.
	 * 
	 */
	private static class ViewHolder {
		public TextView textView;
		public ImageView imageView;
	}

	public AllItemAdapter(Context context, ArrayList<ItemInfo> apps) {
		super(context, 0, apps);
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View gridView = convertView;
		if (gridView == null) {
			gridView = inflater.inflate(R.layout.all_apps_grid_item, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.textView = (TextView) gridView.findViewById(R.id.label);
			viewHolder.imageView = (ImageView) gridView.findViewById(R.id.image);
			gridView.setTag(viewHolder);
		}

		ViewHolder holder = (ViewHolder) gridView.getTag();
		final ItemInfo info = getItem(position);

		holder.textView.setText(info.getTitle());

		info.renderIcon(holder.imageView);

		return gridView;
	}
}