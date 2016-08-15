package com.Surfmerchants.categories;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;

/**
 * Created by Jonathan on 8/15/2016.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory({Minor.class})
public interface Minor {
}
