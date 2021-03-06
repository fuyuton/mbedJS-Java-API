/*
 * Copyright 2014 R.Iizuka
 * http://nyatla.jp/mimic/
 * nyatla39@gmail.com
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.nyatla.mimic.mbedjs;

import jp.nyatla.mimic.mbedjs.javaapi.Mcu;

/**
 * リモートクラスのベースクラスです。
 * リモートクラスはリモートMCU内にインスタンスを持たないクラスです。
 */
public class McuClass{
	protected Mcu _mcu;
	protected String _rpc_class_name;
	protected int _remote_instance_id;
	public McuClass(Mcu i_mcu,String i_rpc_class_name)
	{
		this._rpc_class_name=i_rpc_class_name;
		this._mcu=i_mcu;
	}
	protected JsonRpcResult rawRpc(String i_function,String i_params) throws MbedJsException
	{
		return this._mcu.rpc(this._rpc_class_name+":"+i_function,i_params==null?"":i_params);
	}
	protected JsonRpcResult rawRpc(String i_function) throws MbedJsException
	{
		return this.rawRpc(i_function,null);
	}
}
