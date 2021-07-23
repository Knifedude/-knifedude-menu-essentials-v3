package com.knifedude.menuessentials.api.common.models;

import com.knifedude.menuessentials.api.text.models.Text;

import java.util.Optional;

public interface HasDisplayName {

    Optional<Text> getDisplayName();

}
