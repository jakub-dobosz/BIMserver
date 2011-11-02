package org.bimserver.objectidms;

/******************************************************************************
 * Copyright (C) 2009-2011  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.models.ifc2x3.Ifc2x3Package;
import org.bimserver.plugins.PluginException;
import org.bimserver.plugins.PluginManager;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMPlugin;
import org.bimserver.utils.CollectionUtils;

public class FileBasedObjectIDMPlugin implements ObjectIDMPlugin {

	private boolean initialized;
	private FileBasedObjectIDM fileBasedObjectIDM;

	@Override
	public void init(PluginManager pluginManager) throws PluginException {
		fileBasedObjectIDM = new FileBasedObjectIDM(CollectionUtils.singleSet(Ifc2x3Package.eINSTANCE), pluginManager.getPluginContext(this));
		initialized = true;
	}

	@Override
	public String getDescription() {
		return "FileBasedObjectIDMPlugin";
	}

	@Override
	public String getVersion() {
		return "1.0";
	}

	@Override
	public boolean isInitialized() {
		return initialized;
	}

	@Override
	public ObjectIDM getObjectIDM() {
		return fileBasedObjectIDM;
	}

	@Override
	public String getDefaultObjectIDMName() {
		return "FileBasedObjectIDMPlugin";
	}
}