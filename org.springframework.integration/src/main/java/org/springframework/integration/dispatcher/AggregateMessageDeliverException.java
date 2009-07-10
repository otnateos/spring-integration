/*
 * Copyright 2002-2009 the original author or authors.
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

package org.springframework.integration.dispatcher;

import java.util.List;

import org.springframework.integration.core.Message;
import org.springframework.integration.message.MessageDeliveryException;

/**
 * An Exception that encapsulates an aggregated group of Exceptions for use by
 * dispatchers that may try multiple handler invocations within a single dispatch
 * operation.
 * 
 * @author Mark Fisher
 * @since 1.0.3
 */
@SuppressWarnings("serial")
public class AggregateMessageDeliverException extends MessageDeliveryException {

	private final List<? extends Exception> aggregatedExceptions;


	public AggregateMessageDeliverException(Message<?> undeliveredMessage,
			String description, List<? extends Exception> aggregatedExceptions) {
		super(undeliveredMessage, description);
		this.aggregatedExceptions = aggregatedExceptions;
	}


	public List<? extends Exception> getAggregatedExceptions() {
		return this.aggregatedExceptions;
	}

}
