/*
 * Copyright 2009 JavaBin
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package no.java.ems.client;

import org.codehaus.httpcache4j.Tag;
import org.apache.commons.lang.Validate;

import java.net.URI;

/**
 * @author <a href="mailto:erlend@hamnaberg.net">Erlend Hamnaberg</a>
 * @version $Revision: #5 $ $Date: 2008/09/15 $
 */
public class ResourceHandle {
    private final URI uri;
    private final Tag tag;

    ResourceHandle(final URI uri, final Tag tag) {
        Validate.notNull(uri, "URI may not be null");
        this.uri = uri;
        this.tag = tag;
    }

    public ResourceHandle(final URI pUri) {
        this(pUri, null);
    }

    public URI getUri() {
        return uri;
    }

    Tag getTag() {
        return tag;
    }

    public boolean isTagged() {
        return tag != null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ResourceHandle that = (ResourceHandle) o;

        if (tag != null ? !tag.equals(that.tag) : that.tag != null) {
            return false;
        }
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = uri != null ? uri.hashCode() : 0;
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
